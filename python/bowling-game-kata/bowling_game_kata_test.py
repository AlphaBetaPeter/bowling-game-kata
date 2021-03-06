from bowling_game_kata import BowlingGameKata
import unittest

class BowlingGameKataTest(unittest.TestCase):

		def setUp(self):
			self.game = BowlingGameKata()

		def test_gutter_game(self):
			self.roll_many(20, 0)
			self.assertEquals(0, self.game.score())

		def test_all_ones(self):
			self.roll_many(20, 1)
			self.assertEquals(20, self.game.score())

		def test_one_spare(self):
			self.roll_spare()
			self.game.roll(3)
			self.roll_many(17, 0)
			self.assertEquals(16, self.game.score())

		def test_roll_strike(self):
			self.roll_strike()
			self.game.roll(3)
			self.game.roll(4)
			self.assertEquals(24, self.game.score())

		def test_perfect_game(self):
			self.roll_many(12, 10)
			self.assertEquals(300, self.game.score())

		def roll_strike(self):
			self.game.roll(10)

		def roll_spare(self):
			self.game.roll(5)
			self.game.roll(5)

		def roll_many(self, n, pins):
				for i in range(n):
					self.game.roll(pins)
