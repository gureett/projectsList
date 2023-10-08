# Week 5 Project 1

# Importing twttr
import twttr

def test_shorten():
    assert twttr.shorten("aeiouAEIOUHello50") == "Hll50"

def test_lower_vowels():
    assert twttr.shorten("aeiou") == ""

def test_upper_consonant():
    assert twttr.shorten("C") == "C"

def test_number():
    assert twttr.shorten("2341") == "2341"

def test_punctuation():
    assert twttr.shorten("/.!/") == "/.!/"