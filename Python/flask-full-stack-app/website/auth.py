from flask import Blueprint, render_template, request, redirect, url_for, flash

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
        # print(f"{nom}, {email}, {password}, {password2}")
        if password == password2:
            return redirect(url_for("views.hello"))
    return render_template("signup.html")


@auth.route("/logout")
def logout():
    return render_template("logout.html")
