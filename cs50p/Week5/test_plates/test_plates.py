# Week 5 Project 3

from plates import is_valid

def test_two_letters():
    assert is_valid("CS") == True
    assert is_valid("50") == False

def test_length():
    assert is_valid("A") == False
    assert is_valid("AAAAAAA") == False
    assert is_valid("CS50") == True

def test_zero():
    assert is_valid("CS50") == True
    assert is_valid("CS05") == False

def test_num():
    assert is_valid("AAA222") == True
    assert is_valid("AAA22A") == False

def test_punct():
    assert is_valid("CS50!") == False