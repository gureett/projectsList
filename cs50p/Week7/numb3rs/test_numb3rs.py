from numb3rs import validate

def test_validate():
    assert validate("1.1.1.1") == True
    assert validate("192.168.0.1") == True
    assert validate("255.255.255.255") == True
    assert validate("256.256.256.256") == False
    assert validate("255.256.256.256") == False
    assert validate("cat") == False