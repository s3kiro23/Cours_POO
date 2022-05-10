from flask import Blueprint, render_template

views = Blueprint("views", __name__)


@views.route("/")
def hello():
    class User:
        def __init__(self):
            self.nom = "Sekiro"
            self.age = 46

        def __repr__(self):
            return f"Sekiro"

    sekiro = User()
    return render_template("home.html", user=sekiro, data="ton âme est dans la tourmente...")


@views.route("/contact")
def contact():
    return render_template("contact.html")


@views.route("/apropos")
def apropos():
    return render_template("apropos.html")
