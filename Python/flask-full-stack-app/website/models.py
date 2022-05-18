from . import db
from flask_login import UserMixin


class User(db.Model, UserMixin):
    id = db.Column(db.Integer, primary_key=True)
    nom = db.Column(db.String(30))
    email = db.Column(db.String(50), unique=True)
    password = db.Column(db.String(150))
    secret_question = db.Column(db.String(150))
    secret_response = db.Column(db.String(150))
#    notes = db.relationship('note')


# class Note(db.Model, UserMixin):
#    id = db.Column(db.Integer, primary_key=True)
#   note = db.Column(db.String(150))
#   user_id = db.Column(db.Integer, db.ForeignKey('user.id'))
