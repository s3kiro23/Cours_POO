# Import essential modules - 34
from pygame.transform import scale, rotate

# Function to scale the image by a given factor - 35
def scale_image(image, factor):
    # Calculate the new size of the image given the scale factor - 36
    new_size = round(image.get_width() * factor), round(image.get_height() * factor)
    # Scale the image - 37
    return scale(image, new_size)

# Function to rotate the image of the car - 41
def blit_rotate_center(screen, image, top_left):
    # Rotate the image by the angle - 42

    # Update the "hitbox" of the car - 43

    # Display them on the screen - 44
    screen.blit(image, top_left)

# Create a function to display a text at the center of the screen - 84


