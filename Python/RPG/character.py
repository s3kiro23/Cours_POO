from items import Item


class Character:

    def __init__(self, hero_name: str, hero_class: str, hero_race: str, money: int, hero_pv: int):
        assert hero_name.isalpha(), "Nom invalide..."

        self.__hero_name = hero_name
        self.__hero_class = hero_class
        self.__hero_race = hero_race
        self.__money = money
        self.__hero_pv = hero_pv
        self.__inventory: [Item] = []
        print("Personnage créé avec succés !")

    # Method show inventory

    def inventory(self, inventory):
        self.__inventory = inventory


    def show_inventory(self):
        if len(self.__inventory) == 0:
            print("Vous n'avez pas d'objets dans votre inventaire !")
        else:
            print(f"Inventaire de : {self.__hero_name}")
        for items in self.__inventory:
            print(f" - {items.name}, {items.value} po, {items.durability} % de durabilité")
        print()

    def add_items(self, items):
        if isinstance(items, int):
            self.__inventory.append(items)
            print("Item ajouté avec succés")
        else:
            print("Cet argument n'est pas item")


# Getters define

@property
def hero_name(self):
    return self.__hero_name


@property
def hero_pv(self):
    return self.__hero_pv


@property
def hero_race(self):
    return self.__hero_race


@property
def hero_class(self):
    return self.__hero_class


@property
def money(self):
    return self.__money


@property
def inventory(self):
    return self.__inventory


# Define setters

@hero_name.setter
def hero_name(self, new_name):
    if new_name.isalpha():
        self.__hero_name = new_name
        print(f"Votre personnage s'appelle maintenant {self.__hero_name}")
    else:
        print(f"Non, tu changes de nom de suite !")


@hero_pv.setter
def hero_pv(self, new_pv):
    self.__hero_pv = new_pv


# Method show info character

def show_info(self):
    return self.__repr__()


# Abstraction

def loot_items(self):
    pass


# Magic method

def __repr__(self):
    return f"Voici les stats de votre héro :\n" \
           f"- Nom : {self.__hero_name}\n" \
           f"- Race : {self.__hero_race}\n" \
           f"- Classe : {self.__hero_class}\n" \
           f"- PV : {self.__hero_pv}\n" \
           f"- Bourse : {self.__money}\n"
