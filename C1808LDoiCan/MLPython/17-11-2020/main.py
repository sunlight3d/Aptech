import pandas as pd
from sklearn.linear_model import LinearRegression
from joblib import dump, load
data_frame = pd.read_csv("./areaPrice.csv")
import matplotlib.pyplot as plt
model = LinearRegression()
model.fit(data_frame[['Area']], data_frame.Price) #training
weight = model.coef_
bias = model.intercept_
a_price = model.predict([[82]])
print(f'weight = {weight}, bias = {bias}, a_price = {a_price}')
plt.xlabel('Area')
plt.ylabel('Price(million)')
plt.scatter(data_frame.Area, data_frame.Price, color='red', marker='+')
plt.plot(data_frame.Area, model.predict(data_frame[['Area']]))
import pdb
pdb.set_trace()
dump(model, 'output_model')
