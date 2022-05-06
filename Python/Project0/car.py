class Car:

    # Class attributes

    # Class constructor

    def __init__(self, model: str, price: float, speed: int, nbr_of_seat: int):
        self.model = model
        self.price = price
        self.speed = speed
        self.nbr_of_seat = nbr_of_seat

    # Methods

    def priceChange(self, new_price: int):
        self.price = new_price


# Magic functions

    def __repr__(self):
        return f"Modèle = {self.model} | Prix = {self.price} | Vitesse = {self.speed} | Nombre de sièges = {self.nbr_of_seat}"
