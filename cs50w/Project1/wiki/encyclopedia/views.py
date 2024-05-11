from django.shortcuts import render
from django.http import HttpResponse
from django import forms
from django.urls import reverse
from django.http import HttpResponseRedirect
from markdown import markdown
from random import randrange

from . import util

class NewPageForm(forms.Form):
    title = forms.CharField(required=True, label="")
    contents = forms.CharField(widget=forms.Textarea, label="", required=True)

class EditPageForm(forms.Form):
    contents = forms.CharField(widget=forms.Textarea, label="", required=True)

def index(request):
    try:
        results = []
        if request.method == "POST":
            search_query = (request.POST["q"])
            # Checks if the search result is valid
            for entry in util.list_entries():
                if entry.lower() == search_query.lower():
                    return HttpResponseRedirect(f"wiki/{entry}")
                #else:
                elif search_query in entry:
                    results.append(entry)
            if not len(results) == 0:
                return render(request, "encyclopedia/index.html", {
                "entries" : results
                })
            else:
                return render(request, "encyclopedia/search.html", {
                    "search_query" : search_query
                })
    except (Exception):
        pass

    return render(request, "encyclopedia/index.html", {
        "entries": util.list_entries()
    })

def wikiEntry(request, page):
    try:
        results = []
        if request.method == "POST":
            search_query = (request.POST["q"])
            # Checks if the search result is valid
            for entry in util.list_entries():
                if entry.lower() == search_query.lower():
                    return HttpResponseRedirect(f"wiki/{entry}")
                #else:
                elif search_query in entry:
                    results.append(entry)
            if not len(results) == 0:
                return render(request, "encyclopedia/index.html", {
                "entries" : results
                })
            else:
                return render(request, "encyclopedia/search.html", {
                    "search_query" : search_query
                })
    except (Exception):
        pass

    pageName = "";
    for entry in util.list_entries():
        if entry.lower() == page.lower():
            pageName = entry

    if pageName == "":
        return render(request, "encyclopedia/not_found.html")

    md_to_html = markdown(util.get_entry(pageName))

    return render(request, "encyclopedia/wikiPage.html", {
        "data" : md_to_html, "page" : pageName
    })

def newEntry(request):
    try:
        results = []
        if request.method == "POST":
            search_query = (request.POST["q"])
            # Checks if the search result is valid
            for entry in util.list_entries():
                if entry.lower() == search_query.lower():
                    return HttpResponseRedirect(f"wiki/{entry}")
                #else:
                elif search_query in entry:
                    results.append(entry)
            if not len(results) == 0:
                return render(request, "encyclopedia/index.html", {
                "entries" : results
                })
            else:
                return render(request, "encyclopedia/search.html", {
                    "search_query" : search_query
                })
    except (Exception):
        pass

    # Check if method is POST
    if request.method == "POST":
        # Take in the data the user submitted and save it as form
        form = NewPageForm(request.POST)

        # Check if form data is valid (server-side)
        if form.is_valid():

            # Getting the users input for the title
            titleInput = form.cleaned_data["title"]

            if titleInput.lower() in [entry.lower() for entry in util.list_entries()]:
                # If the form is invalid, re-render the page with existing information.
                return render(request, "encyclopedia/new.html", {
                    "form": form, "error" : "Entry already exists!"
                })

            # Getting users input for the body of the text:
            info = form.cleaned_data["contents"]

            util.save_entry(titleInput, info)

            # Redirect user
            return HttpResponseRedirect(f"wiki/{titleInput}")

        else:

            # If the form is invalid, re-render the page with existing information.
            return render(request, "encyclopedia/new.html", {
                "form": form, "error" : "Enter Title"
            })

    return render(request, "encyclopedia/new.html", {
        "form" : NewPageForm(), "error" : "Enter Title"
    })

def editEntry(request, page):
    try:
        results = []
        if request.method == "POST":
            search_query = (request.POST["q"])
            # Checks if the search result is valid
            for entry in util.list_entries():
                if entry.lower() == search_query.lower():
                    return HttpResponseRedirect(f"wiki/{entry}")
                #else:
                elif search_query in entry:
                    results.append(entry)
            if not len(results) == 0:
                return render(request, "encyclopedia/index.html", {
                "entries" : results
                })
            else:
                return render(request, "encyclopedia/search.html", {
                    "search_query" : search_query
                })
    except (Exception):
        pass

    # Check if method is POST
    if request.method == "POST":
        # Take in the data the user submitted and save it as form
        form = EditPageForm(request.POST)

        # Check if form data is valid (server-side)
        if form.is_valid():

            # Getting the users input for the title
            contents = form.cleaned_data["contents"]

            util.save_entry(page, contents)

            # Redirect user
            return HttpResponseRedirect(f'/wiki/{page}')

        else:

            # If the form is invalid, re-render the page with existing information.
            return render(request, "encyclopedia/edit.html", {
                "form": form
            })

    pageDetails = util.get_entry(page)
    return render(request, "encyclopedia/edit.html", {
        "pageDetails" : pageDetails, "editPage" : page, "form" : EditPageForm({'contents' : pageDetails})
    })

def random(request):
    pages = util.list_entries()
    numOfPages = len(pages) - 1
    randomNum = randrange(0, numOfPages)
    # Redirect user
    return HttpResponseRedirect(f'/wiki/{pages[randomNum]}')

