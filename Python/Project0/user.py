import car
from car import Car


class User:
    # Class attributes
    nationality = 'Japan'
    sudo = 'admin'
    garage = []
    checkRole = True
    mdp = 'zaire'

    # Class constructor
    def __init__(self, first_name: str, last_name: str, money: float, role: str, age=16):
        self.first_name = first_name
        self.last_name = last_name
        self.age = age
        self.money = money
        self.role = role
        self.garage = []
        print(f'Bienvenue {self.first_name} {self.last_name}, dans la classe Hokage ! vous avez {age} ans')

    # Methods

    def modifierAge(self, newAge: int):
        self.age = newAge

    def accessRight(self):

        if self.role == 'user':
            print('Vous n\'avez pas les droits admin !')
            print('Pour redéfinir vos droits d\'accès, tapez 1, sinon tapez 2 pour passer')
            self.nRight = int(input("Votre choix : "))
            if self.nRight == 1:
                nInput: str = ""
                while nInput != self.mdp:
                    nInput = input("Veuillez saisir le mot de passe : ")
                    if nInput == self.mdp:
                        self.role = self.sudo
                        print('Elevation des droits sur votre profil réalisé avec succés')
                    else:
                        print('Mauvais mot de passe')

            elif self.nRight == 2:
                print('Vous passez votre chemin...')

    def checkRole(self):
        if self.role != self.sudo:
            self.checkRole = False
        return self.checkRole

    def addVehicules(self, voiture: Car):
        if isinstance(voiture, Car):
            self.garage.append(voiture)
        else:
            print('\nCe n\'est pas une voiture')

    def showGarage(self):
        if len(self.garage) == 0:
            print('Vous n\'avez pas de voiture')
        elif len(self.garage) == 1:
            print(f'Voici votre véhicule : {self.garage[0]}')
        else:
            print('Voici les véhicules dans votre garage : ')
        for voiture in self.garage:
            print(f"- {voiture}")

    # Static methods

    @staticmethod
    def lot_of_money(money: float):
        if money > 100_000_000_00:
            print('You are rich !')
        else:
            print('Do your actualisation dude...')

    # Magic function

    def __repr__(self):
        return f"Classe {self.__class__.__name__} : {self.first_name} {self.last_name}, {self.age} ans, " \
               f"d'origine {User.nationality} " \
               f"avec {self.money} pcs d'Or dans sa bourse " \
               f"et des droits {self.role}"
