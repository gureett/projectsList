-- Keep a log of any SQL queries you execute as you solve the mystery.

-- Looking at the data the database contains
.schema

-- looking at the tables more cleanly
.tables

-- Finding out what the crime was
SELECT description FROM crime_scene_reports
WHERE year = 2021 AND month = 7 AND day = 28
AND street = 'Humphrey Street';

-- Theft of the CS50 duck took place at 10:15am at the Humphrey Street bakery. Interviews were conducted today with three witnesses who were present at the time – each of their interview transcripts mentions the bakery. Littering took place at 16:36. No known witnesses.

-- Looking at the transcripts for each person
SELECT name, transcript FROM interviews
WHERE year = 2021 AND month = 7 AND day = 28;

-- Narrowing it down to who knows about the theif
SELECT name, transcript FROM interviews
WHERE year = 2021 AND month = 7 AND day = 28;
AND transcript LIKE '%thief' OR 'theft';

-- Witnesses are Ruth, Eugene and Raymond

-- | Ruth    | Sometime within ten minutes of the theft, I saw the thief get into a car in the bakery parking lot and drive away. If you have security footage from the bakery parking lot, you might want to look for cars that left the parking lot in that time frame.                                                          |
-- | Eugene  | I don't know the thief's name, but it was someone I recognized. Earlier this morning, before I arrived at Emma's bakery, I was walking by the ATM on Leggett Street and saw the thief there withdrawing some money.                                                                                                 |
-- | Raymond | As the thief was leaving the bakery, they called someone who talked to them for less than a minute. In the call, I heard the thief say that they were planning to take the earliest flight out of Fiftyville tomorrow. The thief then asked the person on the other end of the phone to purchase the flight ticket. |
SELECT account_number, amount FROM atm_transactions
WHERE year = 2021 AND month = 7 AND day = 28
AND atm_location = 'Leggett Street'
AND transaction_type = 'withdraw';

-- We are given 8 account numbers
SELECT name, atm_transactions.amount FROM people
JOIN bank_accounts ON people.id = bank_accounts.person_id
JOIN atm_transactions ON bank_accounts.account_number = atm_transactions.account_number
WHERE atm_transactions.year = 2021 AND atm_transactions.month = 7 AND atm_transactions.day = 28
AND atm_transactions.atm_location = 'Leggett Street'
AND atm_transactions.transaction_type = 'withdraw';

-- We are given these names: Benista, Taylor, Luca, Iman, Kenny, Brooke, Diana, and Bruce which are now our suspects
-- Going off of Raymonds clue
-- Finding the flights on July 29 from Fiftyville airport
SELECT flights.id, full_name, city, flights.hour, flights.minute FROM airports
JOIN flights ON airports.id = flights.destination_airport_id
WHERE flights.origin_airport_id =
(SELECT id
FROM airports
WHERE city = 'Fiftyville')
AND flights.year = 2021 AND flights.month = 7 AND flights.day = 29
ORDER BY flights.hour, flights.minute;

-- First flight comes at 8:20 to LaGuardia Airport
-- Checking the list of passengers in that flight and putting them all in 'Suspect List'.
SELECT passengers.flight_id, name, passengers.passport_number, passengers.seat FROM people
JOIN passengers ON people.passport_number = passengers.passport_number
JOIN flights ON passengers.flight_id = flights.id
WHERE flights.year = 2021 AND flights.month = 7 AND flights.day = 29 AND flights.hour = 8 AND flights.minute = 20
ORDER BY passengers.passport_number;

-- Bruce, Taylor, Luca, and Kenny are on this flight
-- Checking who started calls
SELECT name, phone_calls.duration FROM people
JOIN phone_calls ON people.phone_number = phone_calls.caller
WHERE phone_calls.year = 2021 AND phone_calls.month = 7 AND phone_calls.day = 28 AND phone_calls.duration <= 60
ORDER BY phone_calls.duration;

-- Taylor and Bruce who were on the earliest flight made calls
-- Checking who recieved calls
SELECT name, phone_calls.duration FROM people
JOIN phone_calls ON people.phone_number = phone_calls.receiver
WHERE phone_calls.year = 2021 AND phone_calls.month = 7 AND phone_calls.day = 28 AND phone_calls.duration <= 60
ORDER BY phone_calls.duration;
-- Bruce was on a call with Robin and Taylor was on a call with James

-- Using ruth's clue
SELECT name, bakery_security_logs.hour, bakery_security_logs.minute FROM people
JOIN bakery_security_logs ON people.license_plate = bakery_security_logs.license_plate
WHERE bakery_security_logs.year = 2021 AND bakery_security_logs.month = 7 AND bakery_security_logs.day = 28
AND bakery_security_logs.activity = 'exit'
AND bakery_security_logs.hour = 10 AND bakery_security_logs.minute >= 15 AND bakery_security_logs.minute <= 25
ORDER BY bakery_security_logs.minute;

-- Bruce drove away