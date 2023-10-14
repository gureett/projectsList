import pytest
from um import count

def test_input():
    assert count("Um, thanks!") == 1
    assert count("Um, um, umm") == 2