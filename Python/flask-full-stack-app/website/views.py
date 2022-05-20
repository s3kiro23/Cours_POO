from flask import Blueprint, render_template, request, redirect, url_for, flash

from .models import User
from .models import Note
from . import db

from flask_login import login_user, logout_user, login_required, current_user

views = Blueprint("views", __name__)


@views.route("/", methods=["GET", "POST"])
@login_required
def hello():
    if request.method == "POST":
        titre = request.form.get("titre")
        description = request.form.get("description")
        check_note = Note.query.filter_by(titre=titre).first()
        if check_note:
            flash("Cette note existe déjà !", category="denied")
            return render_template("home.html", user=current_user)
        if titre:
            new_note = Note(titre=titre, description=description, user_id=current_user.id)
            db.session.add(new_note)
            db.session.commit()
            flash("Note créée avec succès !", category="success")
            return render_template("home.html", user=current_user)
    return render_template("home.html", user=current_user)


@views.route("/contact")
def contact():
    return render_template("contact.html", user=current_user)


@views.route("/apropos")
def apropos():
    return render_template("apropos.html", user=current_user)
