class Solution(object):
    def numSquares(self, n):
        """
        :type n: int
        :rtype: int
        """
        array=[n for i in range(n+1)]
        for i,v in enumerate(array):
            sqrt=int(math,sqrt(v))
            if sqrt*sqrt==n:
                array[i]=1
                continue
            j=1
            while j<=sqrt:
                if array[i-j*j]+1<array[i]:
                    array[i]=array[i-j*j]+1
                j++
        return array[i]