# Import essential modules - 1
from urllib.request import CacheFTPHandler
import pygame
import sys
import random


# Create the snake class - 2

class Snake:
    # Constructor - 3
    def __init__(self):
        self.lengh = 1
        self.positions = [((SCREEN_WIDTH / 2), (SCREEN_HEIGHT / 2))]
        self.direction = random.choice([UP, DOWN, LEFT, RIGHT])
        self.color = (17, 24, 47)
        # Fill the init method with snake attributes : lenght, initial position, initial direction and color - 27

    # Method to get the position of the head of the snake - 4
    def get_head_position(self):
        # Return the position of the head of the snake - 28
        return self.positions [0]

    # Method to turn - 5
    def turn(self):
        pass
        # If the snake is more than 1 case long, it can't go in the direction it is coming - 29

        # Otherwise, it changes its position - 30

    # Method to move - 6
    def move(self):
        pass
        # Calculate the new position of the snake given the current one and the direction - 31

        # If the head of the snake collides with its body, reset the game - 32

        # Otherwise, add the new position at the beginning of the list of positions and remove the last one - 33

    # Method to reset the snake in case of colision - 7
    def reset(self):
        pass
        # Reset the snake with initial attributes - 34

    # Method to draw/display the snake on the board - 8
    def draw(self, surface):        
        # For each part of the snake, create and draw a rectangle of a different color than the board - 35
        for part in self.positions:
            snake = pygame.Rect((part[0], part[1]), (CASE_SIZE, CASE_SIZE))
            pygame.draw.rect(surface, (0, 0, 0), snake)


    # Method to handle (manipuler, traiter) the keys inputs - 9
    def handle_keys(self):
        # Check all the events which can happen - 36
        for event in pygame.event.get():
            # If the player clicks on the "Quit" key, stop the game - 37
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()
            # Otherwise, depending on the pressed key, turn the snake in the corresponding position - 38


# Create the food class - 2 bis
class Food:
    # Contructor - 10
    def __init__(self):
        pass
        # Fill the init method with food attributes : initial position and color - 39

    # Method to randomize a position for the food - 11
    def randomize_food(self):
        pass
        # Randomize the position - 40

    # Method to draw the food on the board - 12
    def draw(self):
        pass
        # Create and draw a rectangle of a different color for the food - 41


# Function to draw the grid - 17
def draw_grid(surface):
    # For each case of the grid - 18
    for y in range(0, int(CASE_HEIGHT)):
        for x in range(0, int(CASE_WIDTH)):
            # If we are on an even case of the grid, we create and draw a rectangle of a first color - 19
            if (x+y) % 2 == 0:
                r = pygame.Rect((x*CASE_SIZE, y*CASE_SIZE), (CASE_SIZE, CASE_SIZE))
                pygame.draw.rect(surface, (93, 216, 228), r)
            # Otherwise, we do the same with another color - 20
            else:
                rr = pygame.Rect((x*CASE_SIZE, y*CASE_SIZE), (CASE_SIZE, CASE_SIZE))
                pygame.draw.rect(surface, (84, 194, 205), rr)
# Global variables (screen size, grid size, possible movements of the snake) - 13
SCREEN_WIDTH = 600
SCREEN_HEIGHT = 600

CASE_SIZE = 20
CASE_WIDTH = SCREEN_WIDTH / CASE_SIZE
CASE_HEIGHT = SCREEN_HEIGHT / CASE_SIZE

UP = (0, -1)
DOWN = (0, 1)
LEFT = (-1, 0)
RIGHT = (1, 0)



def main():
    pass
    # Initialize the game - 14
    pygame.init()
    pygame.display.set_caption("I'm a Snake !")
    # Set up (mettre en place) the clock and the screen - 15
    clock = pygame.time.Clock()
    screen = pygame.display.set_mode((SCREEN_WIDTH, SCREEN_HEIGHT), 0, 32)
    # Set up the game surface - 16
    surface = pygame.Surface(screen.get_size())
    surface = surface.convert()
    # Call the function that draws the grid - 21
    draw_grid(surface)
    # Create a snake and an initial food - 22
    snake = Snake()
    food = Food()
    # Initiliaze the score - 23

    # Configure the font of the score - 47

    # The game loop - 24
    while (True):
        # Choose the number of frames per second - 25
        clock.tick(10)
        # Handle the pressed keys - 42
        snake.handle_keys()
        # Draw the grid - 43

        # Move the snake - 44

        # Check if the snake's head is on a food - 45

        # Draw the snake and the food - 46
        snake.draw(surface)
        # Update and refresh the screen when an action occurs (a lieu) - 26
        screen.blit(surface, (0, 0))
        pygame.display.update()
        # Display the score on the top left corner - 48



if __name__ == "__main__":
    main()