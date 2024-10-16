import pandas as pd
import matplotlib.pyplot as plt
from sklearn.linear_model import LogisticRegression


df = pd.read_csv("hr_dataset.csv")
print(df['Department'])
