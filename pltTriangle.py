import numpy as np
import matplotlib.pyplot as plt
import sys

print 'start'
pt0=[0.,0.]
pt1=[1.,0.]
pt2=[0.5,np.sqrt(3.)/2.]
verts=np.array([pt0,pt1,pt2])

plt.plot(verts[:,0],verts[:,1],'bo')

plt.savefig('tri{:05d}.png'.format(0))

ptc=pt1
ptsx=np.array(ptc[0])
ptsy=np.array(ptc[1])

n=int(sys.argv[1])
for i in range(1,n):
  if i%(n/10)==0:
      print (i*100./n)
  r=np.random.randint(3) 
  ptc=(ptc+verts[r])/2.
  ptsx=np.append(ptsx,ptc[0])
  ptsy=np.append(ptsy,ptc[1])
  plt.plot(ptc[0],ptc[1],'r,')
  plt.savefig('tri{:05d}.png'.format(i))


plt.plot(ptsx,ptsy,'r,')
plt.savefig('points.pdf')
