import csv


class Item:
    all = []

    def __init__(self, item_id: int, name: str, value: int, dura: int):
        assert len(name) > 2, "Nom trop court !"
        assert value > 0, "Saisir une valeur plus importante !"
        self.__item_id = item_id
        self.__name = name
        self.__value = value
        self.__dura = dura
        Item.all.append(self)

    # Getters define

    @property
    def item_id(self):
        return self.__item_id

    @property
    def name(self):
        return self.__name

    @property
    def value(self):
        return self.__value

    @property
    def dura(self):
        return self.__dura

    # Setters define

    @name.setter
    def name(self, name):
        self.__name = name

    @value.setter
    def value(self, value):
        if 0 < value < 1000:
            self.__value = value
        else:
            raise Exception("Valeur beaucoup trop élevée pour l'objet cible !")

    # Abstraction
    def __calcul_dmg(self):
        pass

    def __calcul_defense(self):
        pass

    def fight(self):
        pass

    # Methods of class

    @classmethod
    def create_item(cls):
        with open("items.csv", "r") as f:
            reader = csv.DictReader(f)
            items = list(reader)
        for item in items:
            Item(
                item_id=int(item.get("id")),
                name=item.get("name"),
                value=int(item.get("value")),
                dura=int(item.get("dura"))
            )

    def __repr__(self):
        return f"Ce(tte) {self.__name} vaut {self.__value} pièces d'Or, sa durabilité est de {self.__dura}"
