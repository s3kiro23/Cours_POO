from user import User
from car import Car


def main():
    #    naruto = User(first_name="Naruto", last_name="Uzumaki", money=100000000000, role='user')
    #   naruto.first_name = 'Nana'
    #   naruto.modifierAge(18)
    #   print(naruto)
    #   print(f'Nationality : {User.nationality}')
    #   User.lot_of_money(naruto.money)
    #   naruto.accessRight()
    #   if naruto.checkRole():
    #       naruto.addVehicules()
    #       naruto.showGarage()
    #   else:
    #      print('Droits d\'accès insuffisant')

    ##### Avec fonction de rajout auto des véhicules dans le garage

    Tesla = Car(model='Eco', price=50000, speed=250, nbr_of_seat=5)
    Fiat = Car(model='Punto', price=20000, speed=210, nbr_of_seat=5)
    Renault = Car(model='Clio', price=15000, speed=230, nbr_of_seat=5)
    Ford = Car(model='Mustang', price=35000, speed=320, nbr_of_seat=2)
    print(Tesla)
    print(Fiat)
    print(Renault)
    print(Ford)
    Tesla.priceChange(45000)
    print(f'\nRedéfinition du prix pour la {Tesla.model} : {Tesla.price} euros')
    print('\n===================================\n')
    naruto = User(first_name="Naruto", last_name="Uzumaki", money=100000000000, role='user')
    naruto.modifierAge(18)
    print(naruto)
    User.lot_of_money(naruto.money)
    naruto.accessRight()
    if naruto.checkRole():
        naruto.addVehicules(Tesla)
        naruto.addVehicules(Fiat)
        naruto.addVehicules(Renault)
        naruto.addVehicules(Ford)
        naruto.addVehicules('Toto')
        naruto.addVehicules(1500)
        print('\nVéhicules ajoutés avec succés dans votre garage !')
        print('Opération de rajout des véhicules terminée.\n')
        naruto.showGarage()
    else:
        print('Opération annulée')




if __name__ == "__main__":
    main()
