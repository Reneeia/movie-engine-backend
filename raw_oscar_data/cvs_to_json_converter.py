
import csv
import json
from typing import List

def read_csv_to_list(csv_file_path : str) -> List:
  '''read a cvs file and parse it to python list'''
  data = []
  with open(csv_file_path, encoding='utf-8') as csvf:
    # load csv file data using csv library's dictionary reader
    csv_reader = csv.DictReader(csvf)
    data = list(csv_reader)
  return data

def convert_data(data: List) -> List:
  '''convert raw data format to movie-engine backend schema'''
  transformed_data = []
  for idx, oscar_item in enumerate(data):
    transformed_data.append(
      {
        "id": str(idx+1),
        "yearOfFilm": int(oscar_item['year_film']),
        "yearOfOscar": int(oscar_item['year_ceremony']),
        "seasonOfOscar": int(oscar_item['ceremony']),
        "candidate": oscar_item['name'],
        "category": oscar_item['category'],
        "movieName": oscar_item['film'],
        "movieId": None,
        "isWinner": oscar_item['winner']
      }
    )
  return transformed_data
    

def write_to_json(json_file_path: str, data: List) -> None:
  '''write a python List to json file'''
  with open(json_file_path, 'w', encoding='utf-8') as jsonf:
    json_string = json.dumps(data, indent=4, sort_keys=True)
    jsonf.write(json_string)

def run():
  data = convert_data(read_csv_to_list('./the_oscar_award.csv'))
  write_to_json('./the_oscar_award.json',data)

run()

