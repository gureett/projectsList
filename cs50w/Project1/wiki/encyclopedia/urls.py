from django.urls import path

from . import views

urlpatterns = [
    path("", views.index, name="index"),
    path("wiki/<page>", views.wikiEntry, name="wikiEntry"),
    path("new", views.newEntry, name="new"),
    path("wiki/<page>/edit", views.editEntry, name="edit"),
    path("random", views.random, name="random")
]
