# Import essential modules - 1
from email import utils
from pickle import TRUE
from turtle import position
from starter_utils import scale_image, blit_rotate_center
import pygame
import sys
import time
import math

# Create the game info class - 16
class GameInfo:
    NB_OF_LEVELS = 1
    # Constructor - 17
    def __init__(self):
        pass

    # Method to increase (augmenter) the level - 18
    def increase_level(self):
        pass

    # Method to reset the game - 19
    def reset_game(self):
        pass

    # Method which checks if the game is finished - 20
    def is_game_finished(self):
        pass
        # Return True when the game is finished - 76


    # Method to start the level - 21
    def start_game(self):
        pass
        # Start the level and store the starting time - 77



    # Method to get the time needed for completing the level - 22
    def get_level_time(self):
        pass
        # Get the duration of a level - 78




# Create the player car class - 2
class PlayerCar:
    START_POS = (120, 190)
    # Constructor - 3
    def __init__(self, maximum_velocity, rotation_velocity):
        # Fill the init method with car attributes : image, velocity, maximum velocity, rotation velocity, angle, initial position and acceleration - 39
        self.img = PLAYER_CAR
        self.maximum_velocity = maximum_velocity
        self.rotation_velocity = rotation_velocity
        self.velocity = 0
        self.angle = 0
        self.x, self.y = self.START_POS
        self.acceleration = 0.1
    # Method to rotate the car - 4 
    def rotate(self):
        pass
        # Update the angle with the rotation velocity - 40



    # Method to draw/display the car - 5
    def draw(self, screen):
        # Rotate the image of the car with a function in utils.py - 45
        blit_rotate_center(screen, self.img, (self.x, self.y))

    # Method to move forward (vers l'avant) - 6
    def move_forward(self):
        pass
        # Update the velocity with the acceleration until the limit - 46

        # Move ! - 47


    # Method to move backward (vers l'arrière) - 7
    def move_backward(self):
        pass
        # Update the velocity with the acceleration until the limit - 48

        # Move ! - 49


    # Method to move - 8
    def move(self):
        pass
        # Convert the angle in radians - 50

        # Calculate the vertical and horizontal components of the movement - 51


        # Update the position according to - 52


    # Method to reduce movement speed when no key is pressed - 9
    def reduce_move_speed(self):
        pass
        # Update the velocity with the acceleration until a limit - 53

        # Move ! - 54


    # Method to handle the keys inputs - 10
    def handle_keys(self):
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
            print("HAUT")
        if keys[pygame.K_q]:
            self.rotate()
            print("GAUCHE")
        if keys[pygame.K_s]:
            moving = True
            self.move_backward()
            print("BAS")
        if keys[pygame.K_d]:
            self.rotate()
            print("DROITE")

        # If the car is not moving, reduce its speed - 59
        if not moving:
            self.reduce_move_speed()


    # Method to handle the collisions with the walls - 11
    def collide(self):
        pass
        # Get the car "mask" - 61

        # Calculate the offset between the car and the wall - 62

        # Determine if the car and the wall are overlapping (se superposent), variable poi for point of intersection - 63

        # Return the information - 64


    # Method to handle the bounce (rebond) - 12
    def bounce(self):
        pass
        # When bouncing, revert the velocity - 65

        # Move ! - 66


    # Method to reset the player car - 13
    def reset(self):
        pass
        # Reset the car - 72



# Function to start the level - 23
def start_level():
    pass
    # Check all the events which can happen - 79
    
        # If the player clicks on the "Quit" key, stop the game - 80

        # If the player clicks on any key, start the game - 81


# Function to draw/display all the elements on the screen - 14
def draw_images(screen, images, player_car):
    # For each image, put it on the screen at a given position - 32
    for (images, position) in images:
        screen.blit(images, position)
    # Display informations on the screen: level, time, velocity - 83
    
    # Draw the new elements and update the screen - 33
    player_car.draw(screen)
    pygame.display.update()

# Function to handle collision - 15
def handle_collision():
    pass
    # If there is a collision between the car and a wall, bounce ! - 67


    # Check if the player crossed the finish line in the good direction - 69

        # If this is not the case, bounce ! - 70

        # Otherwise, reset the car and change level - 71



# Global variables (grass, track, track border, finish, car, width, height) - 24
TRACK_SCALE = 0.7
GRASS_SCALE = 2.5
CAR_SCALE = 0.7
FINISH_SCALE = 0.56

GRASS = scale_image(pygame.image.load("imgs/grass.jpg"), GRASS_SCALE)
TRACK = scale_image(pygame.image.load("imgs/track.png"), TRACK_SCALE)
TRACK_BORDER = scale_image(pygame.image.load("imgs/track-border.png"), TRACK_SCALE)
FINISH = scale_image(pygame.image.load("imgs/finish.png"), FINISH_SCALE)
PLAYER_CAR = scale_image(pygame.image.load("imgs/starfox.png"), CAR_SCALE)

SCREEN_WIDTH = TRACK.get_width()
SCREEN_HEIGHT = TRACK.get_height()
# Modify the size of the images with a function in utils.py to scale them - 38


def main():
    # Initialize the game - 25
    pygame.init()
    # Set up the clock and the screen - 26
    clock = pygame.time.Clock()
    screen = pygame.display.set_mode((SCREEN_WIDTH, SCREEN_HEIGHT))
    # Get the game images - 27
    images = [(GRASS, (0, 0)), (TRACK, (0, 0)), (FINISH, (110, 170))]
    # Create a player car and a game info object - 28
    player_car = PlayerCar(4, 4)
    game_info = GameInfo()
    # Initialize the font - 82

    # The game loop - 29
    while TRUE:
        # Choose the number of frames per second - 30
        clock.tick(60)
        # Draw the images on the screen - 31
        draw_images(screen, images, player_car)
        # Wait for the player to press a key to start the game - 85

        # Handle the pressed keys - 60
        player_car.handle_keys()
        # Handle the collision - 68

        # If the game is finished, do what you want (display text, wait, reset...) - 86

if __name__ == "__main__":
    main()