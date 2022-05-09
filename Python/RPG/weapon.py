from items import Item


class Weapon(Item):
    def __init__(self, item_id, name: str, value: int, dura: int, dmg: int):
        super().__init__(item_id, name, value, dura)
        self.dmg = dmg
        print("Une arme a bien été créée !")

    #   def static fight():
    #      print("En Combat")

    # Magic method

    def __repr__(self):
        return f"Ce(tte) {self.name} vaut {self.value} pièces d'Or, sa durabilité est de {self.dura}"
