# Import essential modules - 1
from ctypes import pointer
from urllib.request import CacheFTPHandler
import pygame
import sys
import random


# Create the snake class - 2

class Snake:
    # Constructor - 3
    def __init__(self):
        # Fill the init method with snake attributes : lenght, initial position, initial direction and color - 27
        self.length = 1
        self.position = [((SCREEN_WIDTH_IN_PIXEL / 2), (SCREEN_HEIGHT_IN_PIXEL / 2))]
        self.direction = random.choice([UP, DOWN, LEFT, RIGHT])
        self.color = (17, 24, 47)
        self.speed = 10
        self.score = 0
        self.best_score = 0

    # Method to get the position of the head of the snake - 4
    def get_head_position(self):
        # Return the position of the head of the snake - 28
        return self.position[0]

    # Method to turn - 5
    def turn(self, point):
        # If the snake is more than 1 case long, it can't go in the direction it is coming - 29
        if self.length > 1 and point == (self.direction[0]*(-1), self.direction[1]*(-1)):
            return
        # Otherwise, it changes its position - 30
        else:
            self.direction = point
            print(f"Self dir = {point}")
    # Method to move - 6
    def move(self):
        # Calculate the new position of the snake given the current one and the direction - 31
        current_head_position = self.get_head_position()
        new_head_position = ((current_head_position[0] + self.direction[0]*CASE_SIZE_IN_PIXEL)%SCREEN_WIDTH_IN_PIXEL, (current_head_position[1] + self.direction[1]*CASE_SIZE_IN_PIXEL)%SCREEN_WIDTH_IN_PIXEL)
        # If the head of the snake collides with its body, reset the game - 32
        if self.length > 4 and new_head_position in self.position[4:]:
            self.reset()
        # Otherwise, add the new position at the beginning of the list of position and remove the last one - 33
        else:
            self.position.insert(0, new_head_position)
            if len(self.position) > self.length:
                self.position.pop()
    # Method to reset the snake in case of colision - 7
    def reset(self):
        # Reset the snake with initial attributes - 34
        self.length = 1
        self.position = [((SCREEN_WIDTH_IN_PIXEL / 2), (SCREEN_HEIGHT_IN_PIXEL / 2))]
        self.direction = random.choice([UP, DOWN, LEFT, RIGHT])
        self.speed = 10
        if self.score > self.best_score:
            self.best_score = self.score
        self.score = 0

    # Method to draw/display the snake on the board - 8
    def draw(self, surface):        
        # For each part of the snake, create and draw a rectangle of a different color than the board - 35
        for part in self.position:
            snake = pygame.Rect((part[0], part[1]), (CASE_SIZE_IN_PIXEL, CASE_SIZE_IN_PIXEL))
            pygame.draw.rect(surface, self.color, snake)


    # Method to handle (manipuler, traiter) the keys inputs - 9
    def handle_keys(self):
        # Check all the events which can happen - 36
        for event in pygame.event.get():
            # If the player clicks on the "Quit" key, stop the game - 37
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()
            # Otherwise, depending on the pressed key, turn the snake in the corresponding position - 38
            elif event.type == pygame.KEYDOWN:
                if event.key == pygame.K_z:
                    self.turn(UP)
                elif event.key == pygame.K_s:
                    self.turn(DOWN)
                elif event.key == pygame.K_q:
                    self.turn(LEFT)
                elif event.key == pygame.K_d:
                    self.turn(RIGHT)


# Create the food class - 2 bis
class Food:
    # Contructor - 10
    def __init__(self):
        # Fill the init method with food attributes : initial position and color - 39
        self.position = ((random.randint(0, NB_OF_CASE_WIDTH-1) * CASE_SIZE_IN_PIXEL), (random.randint(0, NB_OF_CASE_HEIGHT-1) * CASE_SIZE_IN_PIXEL))
        self.color = (233, 163, 49)
    # Method to randomize a position for the food - 11
    def randomize_food(self):
        # Randomize the position - 40
        self.position = ((random.randint(0, NB_OF_CASE_WIDTH-1) * CASE_SIZE_IN_PIXEL), (random.randint(0, NB_OF_CASE_HEIGHT-1) * CASE_SIZE_IN_PIXEL))
    # Method to draw the food on the board - 12
    def draw(self, surface):
        # Create and draw a rectangle of a different color for the food - 41
        food = pygame.Rect((self.position[0], self.position[1]), (CASE_SIZE_IN_PIXEL, CASE_SIZE_IN_PIXEL))
        pygame.draw.rect(surface, self.color, food)

class Buff:

    def __init__(self):
        self.position = ((random.randint(0, NB_OF_CASE_WIDTH-1) * CASE_SIZE_IN_PIXEL), (random.randint(0, NB_OF_CASE_HEIGHT-1) * CASE_SIZE_IN_PIXEL))
        self.color = (60, 179, 113)

    def randomize_buff(self):
        self.position = ((random.randint(0, NB_OF_CASE_WIDTH-1) * CASE_SIZE_IN_PIXEL), (random.randint(0, NB_OF_CASE_HEIGHT-1) * CASE_SIZE_IN_PIXEL))
    
    def draw(self, surface, score):
        if score % 10 == 0 and score > 0:
            buff = pygame.Rect((self.position[0], self.position[1]), (CASE_SIZE_IN_PIXEL, CASE_SIZE_IN_PIXEL))
            pygame.draw.rect(surface, self.color, buff)

class Wall:

    def __init__(self):
        self.position = ((random.randint(0, NB_OF_CASE_WIDTH-1) * CASE_SIZE_IN_PIXEL), (random.randint(0, NB_OF_CASE_HEIGHT-1) * CASE_SIZE_IN_PIXEL))
        self.color = (255,0,0)

    def randomize_wall(self):
        self.position = ((random.randint(0, NB_OF_CASE_WIDTH-1) * CASE_SIZE_IN_PIXEL), (random.randint(0, NB_OF_CASE_HEIGHT-1) * CASE_SIZE_IN_PIXEL))

    def draw(self, surface):
        wall = pygame.Rect((self.position[0], self.position[1]), (CASE_SIZE_IN_PIXEL, CASE_SIZE_IN_PIXEL))
        pygame.draw.rect(surface, self.color, wall)

# Function to draw the grid - 17
def draw_grid(surface):
    # For each case of the grid - 18
    for y in range(0, int(NB_OF_CASE_HEIGHT)):
        for x in range(0, int(NB_OF_CASE_WIDTH)):
            # If we are on an even case of the grid, we create and draw a rectangle of a first color - 19
            if (x+y) % 2 == 0:
                r = pygame.Rect((x*CASE_SIZE_IN_PIXEL, y*CASE_SIZE_IN_PIXEL), (CASE_SIZE_IN_PIXEL, CASE_SIZE_IN_PIXEL))
                pygame.draw.rect(surface, (93, 216, 228), r)
            # Otherwise, we do the same with another color - 20
            else:
                rr = pygame.Rect((x*CASE_SIZE_IN_PIXEL, y*CASE_SIZE_IN_PIXEL), (CASE_SIZE_IN_PIXEL, CASE_SIZE_IN_PIXEL))
                pygame.draw.rect(surface, (84, 194, 205), rr)
# Global variables (screen size, grid size, possible movements of the snake) - 13
SCREEN_WIDTH_IN_PIXEL = 600
SCREEN_HEIGHT_IN_PIXEL = 600

CASE_SIZE_IN_PIXEL = 20
NB_OF_CASE_WIDTH = SCREEN_WIDTH_IN_PIXEL / CASE_SIZE_IN_PIXEL
NB_OF_CASE_HEIGHT = SCREEN_HEIGHT_IN_PIXEL / CASE_SIZE_IN_PIXEL

UP = (0, -1)
DOWN = (0, 1)
LEFT = (-1, 0)
RIGHT = (1, 0)



def main():
    # Initialize the game - 14
    pygame.init()
    pygame.display.set_caption("I'm a Snake !")
    # Set up (mettre en place) the clock and the screen - 15
    clock = pygame.time.Clock()
    screen = pygame.display.set_mode((SCREEN_WIDTH_IN_PIXEL, SCREEN_HEIGHT_IN_PIXEL), 0, 32)
    # Set up the game surface - 16
    surface = pygame.Surface(screen.get_size())
    surface = surface.convert()
    # Call the function that draws the grid - 21
    draw_grid(surface)
    # Create a snake, an initial food and wall - 22
    snake = Snake()
    food = Food()
    wall = Wall()
    buff = Buff()
    # Initiliaze the score - 23
    snake.score = 0
    # Configure the font of the score - 47
    pygame.font.init()
    myfont = pygame.font.SysFont("monospace", 16)
    # The game loop - 24

    while (True):
        # Choose the number of frames per second - 25
        clock.tick(snake.speed)
        # Handle the pressed keys - 42
        snake.handle_keys()
        # Draw the grid - 43
        draw_grid(surface)
        # Move the snake - 44
        snake.move()
        # Check if the snake's head is on a food - 45
        if snake.position[0] == food.position:
            snake.length+=1
            food.randomize_food()
            snake.speed+=1
            snake.score+=1
        if snake.position[0] == wall.position:
            snake.reset()
        if snake.position[0] == buff.position:
            snake.length-=2
            snake.speed-=5
            snake.score+=2
        # Draw the snake and the food - 46
        snake.draw(surface)
        food.draw(surface)
        wall.draw(surface)
        buff.draw(surface, snake.score)
        # Update and refresh the screen when an action occurs (a lieu) - 26
        screen.blit(surface, (0, 0))
        # Display the score on the top left corner - 48
        text = myfont.render("Score : {0}               Best Score : {1}".format(snake.score, snake.best_score), 1, (0, 0, 0))
        screen.blit(text, (5, 10))
        pygame.display.update()


if __name__ == "__main__":
    main()