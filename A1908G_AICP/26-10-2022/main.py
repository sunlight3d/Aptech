import numpy as np
from scipy import stats as statistics

array1 = np.array([21, 13, 18, 18, 16, 14, 17, 13, 18, 12, 22, 13])
array1 = np.sort(array1)
print("array1(after sort): "+str(array1))
print ("mean = "+str(np.average(array1)))
print ("median = "+str(np.median(array1)))
print(  "mode = "+str(statistics.mode(array1).mode[0]) +\
        ", count : "+str(statistics.mode(array1).count[0]) )
# import pdb
# pdb.set_trace()
print("range: "+str(np.max(array1) - np.min(array1)) )
print("range: "+str(np.ptp(array1,axis=0)) )

