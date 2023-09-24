from sys import exit
import json
import requests
import schedule
import time

def main():
    schedule.every().day.at("07:20").do(send_weather_update)
    while True:
        schedule.run_pending()
        time.sleep(1)

def send_discord_webhook(info):
    webhook_url = "https://discord.com/api/webhooks/YOUR_WEBHOOK_ID/YOUR_WEBHOOK_TOKEN"
  
    payload = {
    "content": info
    }
    
    dw_response = requests.post(webhook_url, data=json.dumps(payload), headers={"Content-Type": "application/json"})
    if dw_response.status_code == 204:
      print("Message sent successfully")
    else:
      print(f"Failed to send message. Status code: {dw_response.status_code}")

def send_weather_update():
    location_data = get_location_info()
    lat = location_data[0]["lat"]
    lon = location_data[0]["lon"]
    city = location_data[0]['name']

    weather_data = get_weather(lat, lon)
    temp_celsius = weather_data["hourly"]["temperature_2m"][0]
    relative_humidity = weather_data["hourly"]["relativehumidity_2m"][0]
    wind_speed = weather_data["hourly"]["windspeed_10m"][0]

    weather_info = (
        f"Good Morning!\n"
        f"The current weather in {city}:\n"
        f"Temperature: {temp_celsius:.2f}C\n"
        f"Relative Humidity: {relative_humidity}%\n"
        f"Wind Speed: {wind_speed} m/s\n"
    )

    send_discord_webhook(weather_info)
    

def get_location_info():

    loc_base_url = "https://nominatim.openstreetmap.org/search"
    print("Please enter your city and country as in following this format, without the brackets: (Toronto, Canada)")
    location = input()

    params = {
    "q": location,
    "format": "json",  # Request the response in JSON format
    "limit": 1,  # Limit the number of results to 1
    }

    try:
        loc_response = requests.get(loc_base_url, params=params)

        if loc_response.status_code == 200:
            data = loc_response.json()
            if data:
                return data
            else:
                print("Error Occured! Please ensure all fields were entered properly!")
                exit(1)
        else:
            print(f"Request failed with status code {loc_response.status_code}")
            exit(loc_response.status_code)
    except requests.exceptions.RequestException as e:
        print(f"Request error: {e}")
        exit(1)

def get_weather(lat, lon):
    weather_base_url = f"https://api.open-meteo.com/v1/forecast?latitude={lat}&longitude={lon}&current_weather=true&hourly=temperature_2m,relativehumidity_2m,windspeed_10m"
    try:
        weather_response = requests.get(weather_base_url)
        weather_data = weather_response.json()
        return weather_data
    except requests.exceptions.RequestException as e:
        print(f"Request error: {e}")
        exit(1)

send_weather_update()