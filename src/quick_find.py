# -*- coding: utf-8 -*-

class QuickFindUF(object):
    '''
    union find
    '''
    def __init__(self, N):
        self.N = N
        self.idx = range(N)
        self.count = 0

    def find(self, p):
        '''
        return idx of p
        '''
        return self.idx[p]

    def connected(self, p, q):
        '''
        check if p & q share a connection.
        '''
        if self.find(p) == self.find(q):
            return True
        else:
            return False

    def union(self, p, q):
        '''
        union p & q together.
        '''
        p_id = self.find(p)
        q_id = self.find(q)

        if not p_id == q_id:
            for i in xrange(self.N):
                if self.idx[i] == p_id:
                    self.idx[i] = q_id

# test client
if __name__ == "__main__":
    uf = QuickFindUF(100)
    uf.union(6, 5)
    uf.union(2, 3)
    uf.union(1, 4)
    print "Are {0} and {1} connected?\n{2}".format(1, 4, uf.connected(1, 4))
    print "Are {0} and {1} connected?\n{2}".format(1, 5, uf.connected(1, 5))
