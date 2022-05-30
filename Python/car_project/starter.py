# Import essential modules - 1
from cgitb import text
from cmath import cos
from email import utils
from pickle import FALSE, TRUE
from tkinter import font
from turtle import position
from starter_utils import scale_image, blit_rotate_center, blit_text_center,  blit_countdown_center
import pygame
import sys
import time
import math
import asyncio

# Create the game info class - 16
class GameInfo:
    NB_OF_LEVELS = 1
    # Constructor - 17
    def __init__(self, level=1):
        self.level = level
        self.started = False
        self.level_start_time = 0

    # Method to increase (augmenter) the level - 18
    def increase_level(self):
        self.level += 1

    # Method to reset the game - 19
    def reset_game(self):
        self.level = 1
        self.started = False
        self.level_start_time = 0

    # Method which checks if the game is finished - 20
    def is_game_finished(self):
        # Return True when the game is finished - 76
        return self.level > self.NB_OF_LEVELS

    # Method to start the level - 21
    def start_level(self):
        # Start the level and store the starting time - 77
        self.started = True
        self.level_start_time = time.time()

    # Method to get the time needed for completing the level - 22
    def get_level_time(self):
        # Get the duration of a level - 78
        if not self.started:
            return 0
        return time.time() - self.level_start_time
    
    # Compte à rebours départ course
    def countdown(self, num_of_secs, screen, font):
        while num_of_secs:
            print(num_of_secs)
            pygame.mixer.music.set_volume(2.0)
            pygame.mixer.music.load("Start.mp3")
            pygame.mixer.music.play()
            blit_countdown_center(screen, font, f"{num_of_secs}")
            pygame.display.flip()
            time.sleep(1)
            num_of_secs -= 1


# Create the player car class - 2
class PlayerCar:
    # Constructor - 3
    def __init__(self, img, start, maximum_velocity, rotation_velocity):
        # Fill the init method with car attributes : image, velocity, maximum velocity, rotation velocity, angle, initial position and acceleration - 39
        self.img = img
        self.maximum_velocity = maximum_velocity
        self.rotation_velocity = rotation_velocity
        self.velocity = 0
        self.angle = 0
        self.initial_position = start
        self.x, self.y = self.initial_position
        self.acceleration = 0.1
    # Method to rotate the car - 4 
    def rotate(self, left=False, right=False):
        # Update the angle with the rotation velocity - 40
        if left:
            self.angle += self.rotation_velocity
        if right:
            self.angle -= self.rotation_velocity

    # Method to draw/display the car - 5
    def draw(self, screen):
        # Rotate the image of the car with a function in utils.py - 45
        blit_rotate_center(screen, self.img, (self.x, self.y), self.angle)

    # Method to move forward (vers l'avant) - 6
    def move_forward(self):
        # Update the velocity with the acceleration until the limit - 46
        self.velocity = min(self.velocity + self.acceleration, self.maximum_velocity)

        # Move ! - 47
        self.move()

    # Method to move backward (vers l'arrière) - 7
    def move_backward(self):
        # Update the velocity with the acceleration until the limit - 48
        self.velocity = max(self.velocity - self.acceleration, -self.maximum_velocity/2)
        # Move ! - 49
        self.move()
    
    def boost(self):
        self.velocity = min(self.velocity + self.acceleration*1.5, self.maximum_velocity*1.5)

        self.move()
    
    def mario_start(self):
        self.velocity = self.maximum_velocity*2

    # Method to move - 8
    def move(self):
        # Convert the angle in radians - 50
        angle_radiant = math.radians(self.angle)
        # Calculate the vertical and horizontal components of the movement - 51
        y = self.velocity * math.cos(angle_radiant)
        x = self.velocity * math.sin(angle_radiant)
        # Update the position according to - 52
        self.y -= y
        self.x -= x

    # Method to reduce movement speed when no key is pressed - 9
    def reduce_move_speed(self):
        # Update the velocity with the acceleration until a limit - 53
        if self.velocity > 0:
            self.velocity = max(self.velocity - self.acceleration/2, 0)
        else:
            self.velocity = min(self.velocity + self.acceleration/2, 0)
        # Move ! - 54
        self.move()

    # Method to handle the keys inputs for player one - 10
    def handle_keys_p1(self):
        # Check all the events which can happen - 54
        for event in pygame.event.get():
            # If the player clicks on the "Quit" key, stop the game - 55
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()
        # Get the keys pressed - 56
        keys = pygame.key.get_pressed()
        # Initialize a variable to check if the car is moving - 57
        moving = False
        # Depending on the pressed key, move the car and update the moving variable if necessary - 58
        if keys[pygame.K_z]:
            moving = True
            self.move_forward()
        elif keys[pygame.K_s]:
            moving = True
            self.move_backward()
        if keys[pygame.K_LSHIFT]:
            moving=True
            self.boost()
        if keys[pygame.K_SPACE]:
            moving=True
            self.mario_start()
        if keys[pygame.K_q]:
            self.rotate(left=True)
        if keys[pygame.K_d]:
            self.rotate(right=True)

        # If the car is not moving, reduce its speed - 59
        if not moving:
            self.reduce_move_speed()

    # Method to handle the keys inputs for player two - 10
    def handle_keys_p2(self):
        # Check all the events which can happen - 54
        for event in pygame.event.get():
            # If the player clicks on the "Quit" key, stop the game - 55
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()
        # Get the keys pressed - 56
        keys = pygame.key.get_pressed()
        # Initialize a variable to check if the car is moving - 57
        moving = False
        # Depending on the pressed key, move the car and update the moving variable if necessary - 58
        if keys[pygame.K_UP]:
            moving = True
            self.move_forward()
        elif keys[pygame.K_DOWN]:
            moving = True
            self.move_backward()
        if keys[pygame.K_RSHIFT]:
            moving=True
            self.boost()
        if keys[pygame.K_RCTRL]:
            moving=True
            self.mario_start()
        if keys[pygame.K_LEFT]:
            self.rotate(left=True)
        if keys[pygame.K_RIGHT]:
            self.rotate(right=True)

        # If the car is not moving, reduce its speed - 59
        if not moving:
            self.reduce_move_speed()

    # Method to handle the collisions with the walls - 11
    def collide(self, mask, x=0, y=0):
        # Get the car "mask" - 61
        car_mask = pygame.mask.from_surface(self.img).scale((self.img.get_width()*0.7, self.img.get_height()*0.7))
        # Calculate the offset between the car and the wall - 62
        offset = (int(self.x - x), int(self.y - y))
        # Determine if the car and the wall are overlapping (se superposent), variable poi for point of intersection - 63
        poi = mask.overlap(car_mask, offset)
        # Return the information - 64
        return poi

    # Method to handle the bounce (rebond) - 12
    def bounce(self):
        # When bouncing, revert the velocity - 65
        self.velocity = -self.velocity*0.5
        # Move ! - 66
        self.move()

    # Method to reset the player car - 13
    def reset(self):
        # Reset the car - 72
        self.velocity = 0
        self.angle = 0
        self.x, self.y = self.initial_position        

# Function to start the level - 23
def start_level(game_info, screen, font):
    # Check all the events which can happen - 79
    for event in pygame.event.get():
        
        # If the player clicks on the "Quit" key, stop the game - 80
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()
        # If the player clicks on any key, start the game - 81
        if event.type == pygame.KEYDOWN:
            game_info.countdown(3, screen, font)
            game_info.start_level()
            pygame.mixer.music.set_volume(1.0)
            pygame.mixer.music.load("F-Zero - Mute City.mp3")
            pygame.mixer.music.play()

# Function to draw/display all the elements on the screen - 14
def draw_images(screen, images, player_car_P1, player_car_P2, game_info, font):
    # For each image, put it on the screen at a given position - 32
    for (images, position) in images:
        screen.blit(images, position)
    # Display informations on the screen: level, time, velocity - 83
    level_text = font.render(f"Level: {game_info.level}", 1, (255, 255, 255))
    screen.blit(level_text, (10, SCREEN_HEIGHT - level_text.get_height() - 80))

    time_text = font.render(f"Time: {round(game_info.get_level_time(), 1)}s", 1, (255, 255, 255))
    screen.blit(time_text, (10, SCREEN_HEIGHT - time_text.get_height() - 40))

    vel_text = font.render(f"Vel: {round(player_car_P1.velocity, 1)}px/s", 1, (255, 255, 255))
    screen.blit(vel_text, (10, SCREEN_HEIGHT - vel_text.get_height() - 0))

    # Draw the new elements and update the screen - 33
    player_car_P1.draw(screen)
    player_car_P2.draw(screen)
    pygame.display.update()

# Function to handle collision - 15
def handle_collision(player_car, game_info):
    # If there is a collision between the car and a wall, bounce ! - 67
    if player_car.collide(TRACK_BORDER_MASK):
        player_car.bounce()

    # Check if the player crossed the finish line in the good direction - 69
    player_finish_poi_collide = player_car.collide(FINISH_MASK, *FINISH_POSITION)
    if player_finish_poi_collide:
        # If this is not the case, bounce ! - 70
        if player_finish_poi_collide[1] == 0 :
            player_car.bounce()
        # Otherwise, reset the car and change level - 71
        else:
            player_car.reset()
            game_info.increase_level()


# Global variables (grass, track, track border, finish, car, width, height) - 24
TRACK_SCALE = 0.7
GRASS_SCALE = 2.5
CAR_SCALE = 0.7
CAR_SCALE_P1 = 0.4
FINISH_SCALE = 0.56

# Modify the size of the images with a function in utils.py to scale them - 38

GRASS = scale_image(pygame.image.load("imgs/grass.jpg"), GRASS_SCALE)
TRACK = scale_image(pygame.image.load("imgs/track.png"), TRACK_SCALE)
TRACK_BORDER = scale_image(pygame.image.load("imgs/track-border.png"), TRACK_SCALE)
TRACK_BORDER_MASK = pygame.mask.from_surface(TRACK_BORDER)
FINISH = scale_image(pygame.image.load("imgs/finish.png"), FINISH_SCALE)
FINISH_MASK = pygame.mask.from_surface(FINISH)
FINISH_POSITION = (110, 210)
PLAYER_CAR_P1 = scale_image(pygame.image.load("imgs/starfox.png"), CAR_SCALE_P1)
PLAYER_CAR_P2 = scale_image(pygame.image.load("imgs/faucon.png"), CAR_SCALE)

SCREEN_WIDTH = TRACK.get_width()
SCREEN_HEIGHT = TRACK.get_height()



def main():
    # Initialize the game - 25
    pygame.init()
    # Set up the clock and the screen - 26
    clock = pygame.time.Clock()
    screen = pygame.display.set_mode((SCREEN_WIDTH, SCREEN_HEIGHT))
    # Get the game images - 27
    images = [(GRASS, (0, 0)), (TRACK, (0, 0)), (TRACK_BORDER, (0, 0)), (FINISH, FINISH_POSITION)]
    # Create a player car and a game info object - 28
    player_car_P1 = PlayerCar(PLAYER_CAR_P1,(117, 190), 4, 4)
    player_car_P2 = PlayerCar(PLAYER_CAR_P2,(135, 184), 4, 4)
    game_info = GameInfo()
    # Initialize pygame music and volume
    pygame.mixer.init()
    pygame.mixer.music.set_volume(1.0)
    pygame.mixer.music.load("F-Zero - menu.mp3")
    pygame.mixer.music.play()

    # Initialize the font - 82
    pygame.font.init()
    my_font = pygame.font.SysFont("comicsans", 30)
    
    # The game loop - 29
    while TRUE:
        # Choose the number of frames per second - 30
        clock.tick(60)
        # Draw the images on the screen - 31
        draw_images(screen, images, player_car_P1, player_car_P2, game_info, my_font)
        # Wait for the player to press a key to start the game - 85
        while not game_info.started:
            pygame.display.update()
            blit_text_center(screen, my_font, f"Press any key to start level")
            start_level(game_info, screen, my_font)

        # Handle the pressed keys - 60
        player_car_P1.handle_keys_p1()
        player_car_P2.handle_keys_p2()
        # Handle the collision - 68
        handle_collision(player_car_P1, game_info)
        handle_collision(player_car_P2, game_info)
        # If the game is finished, do what you want (display text, wait, reset...) - 86
        if game_info.is_game_finished():
            blit_text_center(screen, my_font,"You won the game !")
            pygame.mixer.music.load("F-Zero - Ending Theme.mp3")
            pygame.mixer.music.play()
            pygame.display.update()
            pygame.time.wait(10000)
            game_info.reset_game()
            player_car_P1.reset()
            player_car_P2.reset()

if __name__ == "__main__":
    main()