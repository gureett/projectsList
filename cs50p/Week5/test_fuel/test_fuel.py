# Week 5 Project 4

# Importing
import pytest
from fuel import convert, gauge

def test_convert():
    assert convert("1/2") == 50
    assert convert("1/100") == 1

def test_gauge():
    assert gauge(23) == "23%"
    assert gauge(99) == "F"
    assert gauge(1) == "E"

def test_zero():
    with pytest.raises(ZeroDivisionError):
        convert("1/0")

def test_value():
    with pytest.raises(ValueError):
        convert("2/1")