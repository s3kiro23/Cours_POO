from flask import Blueprint, render_template, request, redirect, url_for, flash

from . import db
from .models import User

from werkzeug.security import generate_password_hash, check_password_hash
from flask_login import login_user, logout_user, login_required, current_user

auth = Blueprint("auth", __name__)


@auth.route("/login", methods=["GET", "POST"])
def login():
    if current_user.is_authenticated:
        return redirect(url_for("views.hello"))
    if request.method == "POST":
        email = request.form.get("email")
        password = request.form.get("password")
        user = User.query.filter_by(email=email).first()
        if user:
            if check_password_hash(user.password, password):
                login_user(user)
                flash("Connexion réussi !", category="success")
                return redirect(url_for("views.hello"))
            else:
                flash("Mauvais mot de passe !", category="denied")
        else:
            flash("Compte utilisateur inexistant !", category="denied")
    return render_template("login.html", user=current_user)


@auth.route("/signup", methods=["GET", "POST"])
def signup():
    if current_user.is_authenticated:
        return redirect(url_for("views.hello"))
    if request.method == "POST":
        nom = request.form.get("nom")
        email = request.form.get("email")
        password = request.form.get("password")
        password2 = request.form.get("password2")
        user = User.query.filter_by(email=email).first()
        if user:
            flash("Cet utilisateur existe déjà !", category="denied")
            return render_template("signup.html", user=current_user)
        else:
            if password == password2:
                new_user = User(nom=nom, email=email, password=generate_password_hash(password, method="sha256"))
                db.session.add(new_user)
                db.session.commit()
                login_user(new_user)
                flash("Compte créé avec succés !", category="success")
                return redirect(url_for("views.hello", user=current_user))
            flash("Les mots de passe ne correspondent pas !", category="denied")
    return render_template("signup.html", user=current_user)


@auth.route("/logout")
@login_required
def logout():
    logout_user()
    return redirect(url_for("auth.login"))


@auth.route("/forgot-pwd")
def forgot_pwd():
    if request.method == "POST":
        email = request.form.get("email")
        password = request.form.get("password")
        user = User.query.filter_by(email=email).first()
        if user:
            if check_password_hash(user.password, password):
                flash("Connexion réussi !", category="success")
                return redirect(url_for("views.hello"))
            else:
                flash("Mauvais mot de passe !", category="denied")
        else:
            flash("Compte utilisateur inexistant !", category="denied")
        return render_template("login.html", user=current_user)

    return render_template("forgot-pwd.html", user=current_user)
