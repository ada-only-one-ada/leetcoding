from collections import defaultdict
import bisect
class RangeFreqQuery:

    def __init__(self, arr: List[int]):
        self.d = defaultdict(list)
        n = len(arr)
        self.arr = arr
        for i in range(n):
            self.d[arr[i]].append(i)
        

    def query(self, left: int, right: int, value: int) -> int:
        if value not in self.d:
            return 0
        lindex = bisect.bisect_left(self.d[value],left)
        rindex = bisect.bisect_left(self.d[value],right)
        if rindex>=len(self.d[value]):
            rindex-=1
        if self.d[value][rindex]>right:
            rindex-=1
        return rindex-lindex+1