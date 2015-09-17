# -*- coding: utf-8 -*-

class QuickFindUF(object):
    def __init__(self, N):
        self.N = N
        self.idx = range(N)
        self.count = 0

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
        self.count = 0

    def union(self, p, q):
        pass


# test client
if __name__ == "__main__":
    uf = QuickFindUF(100)
    uf.union(6, 5)
    uf.union(2, 3)
    uf.union(1, 4)
    print "Are {0} and {1} connected?\n{2}".format(1, 4, uf.connected(1, 4))
    print "Are {0} and {1} connected?\n{2}".format(1, 5, uf.connected(1, 5))
