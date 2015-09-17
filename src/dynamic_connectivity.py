# -*- coding: utf-8 -*-

class QuickFindUF(object):
    def __init__(self, N):
        self.N = N
        self.idx = range(N)
        self.count = self.N

    def count(self):
        return self.count

    def find(self, p):
        return self.idx[p]

    def connected(self, p, q):
        if self.find(p) == self.find(q):
            return True
        else:
            return False

    def union(self, p, q):
        p_id = self.find(p)
        q_id = self.find(q)

        if not p_id == q_id:
            for i in xrange(self.N):
                if self.idx[i] == p_id:
                    self.idx[i] = q_id

class QuickUnionUF(QuickFindUF):
    def __init__(self, N):
        super(QuickUnionUF, self).__init__(N)
        self.idx = range(N)
        self.count = self.N

    def find(self, p, q):
        while p != self.idx[p]:
            p = self.idx[p];

        return p;

    def union(self, p, q):
        i = self.find(p)
        j = self.find(q)
        if i == j:
            pass

        id[i] = j

        self.count -= 1

class WeightedQuickUnionUF(QuickUnionUF):
    def __init__(self, N):
        super(WeightedQuickUnionUF, self).__init__(N)
        self.idx = range(N)
        self.sz = [1]*N
        self.count = self.N

    def find(self, p):
        while p != self.idx[p]:
            p = self.idx[p]

        return p;

    def union(self, p, q):
        i = self.find(p)
        j = self.find(q)
        if i == j:
            pass

        if self.sz[i] < self.sz[j]:
            self.idx[i] = j
            self.sz[j] += self.sz[i]
        else:
            self.idx[j] = i
            self.sz[i] += self.sz[j]

        self.count -= 1

### test client
if __name__ == "__main__":
    uf = WeightedQuickUnionUF(100)
    uf.union(6, 5)
    uf.union(2, 3)
    uf.union(1, 4)
    print "Are {0} and {1} connected?\n{2}".format(1, 4, uf.connected(1, 4))
    print "Are {0} and {1} connected?\n{2}".format(1, 5, uf.connected(1, 5))
