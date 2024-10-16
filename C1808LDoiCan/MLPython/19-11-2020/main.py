# -*- coding: utf-8 -*-
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split
import pandas as pd
import math
print("hello")
def area_price_prediction():
    data_frame = pd.read_csv("./areaPrice.csv")
    median_number_of_rooms = math.ceil(data_frame.numberOfRooms.median())
    data_frame.numberOfRooms = data_frame.numberOfRooms.fillna(median_number_of_rooms)
    model = LinearRegression()
    #training 
    features = data_frame[["area","years", "numberOfRooms"]]
    label = data_frame['price']
    model.fit(features, label)
    #model.predict([[74,8,3 ]])
    #model.score([[72,4,2], [74,8,3]], [1261.316, 1383.1242])
    data_frame.to_csv("temp.csv")
    plt.scatter(data_frame["years"], data_frame["price"])
    plt.show()


data_frame = pd.read_csv("Salary.csv")
X_train, X_test, y_train, y_test = train_test_split(data_frame[['YearsExperience']],data_frame['Salary'], test_size=0.1)
model = LinearRegression()
#model.fit(X_train, y_train)


