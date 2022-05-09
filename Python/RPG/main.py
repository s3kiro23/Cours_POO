from character import Character
from weapon import Weapon
from items import Item


def main():
    hero1 = Character(hero_name="Arthas", hero_class="Paladin", hero_race="Humain", money=100, hero_pv=200)
    print(hero1)
    potion = Item(item_id=1, name="Pot de soin", value=10, dura=1)
    print(potion)
    sword = Weapon(item_id=0, name="Epée de novice", value=100, dura=100, dmg=130)
    print(sword)
    hero1.add_items(sword)
    hero1.show_inventory()


if __name__ == "__main__":
    main()
