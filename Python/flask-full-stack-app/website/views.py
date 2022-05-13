from flask import Blueprint, render_template
from .models import User
from flask_login import login_required, current_user

views = Blueprint("views", __name__)


@views.route("/")
@login_required
def hello():
    return render_template("home.html", user=current_user)


@views.route("/contact")
def contact():
    return render_template("contact.html", user=current_user)


@views.route("/apropos")
def apropos():
    return render_template("apropos.html", user=current_user)
