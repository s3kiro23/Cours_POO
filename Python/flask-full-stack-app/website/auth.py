from flask import Blueprint, render_template, request, redirect, url_for, flash

from . import db
from .models import User

auth = Blueprint("auth", __name__)


@auth.route("/login", methods=["GET", "POST"])
def login():
    if request.method == "POST":
        email = request.form.get("email")
        password = request.form.get("password")
        print(f"{email}, {password}")
        return redirect(url_for("views.hello"))
    return render_template("login.html")


@auth.route("/signup", methods=["GET", "POST"])
def signup():
    if request.method == "POST":
        nom = request.form.get("nom")
        email = request.form.get("email")
        password = request.form.get("password")
        password2 = request.form.get("password2")
        print(f"{nom}, {email}, {password}, {password2}")
        if password == password2:
            new_user = User(nom=nom, email=email, password=password)
            db.session.add(new_user)
            db.session.commit()
            flash("Compte créé avec succés !", category="success")
            return redirect(url_for("views.hello"))
        flash("Les mots de passe ne correspondent pas !", category="denied")
    return render_template("signup.html")


@auth.route("/logout")
def logout():
    return render_template("logout.html")
