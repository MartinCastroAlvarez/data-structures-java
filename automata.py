import typing
import random
import hashlib
import copy

class State:
    def __init__(self, name: str):
        assert name and isinstance(name, str)
        self.name: str = name
    def __repr__(self) -> str:
        return self.name
    def __eq__(self, other: typing.Any) -> bool:
        return other and isinstance(other, self.__class__) and self.name == other.name
    def __hash__(self) -> int:
        return int(hashlib.sha1(self.name.encode("utf-8")).hexdigest(), 16)

class Stack:
    empty: State = State(name='$')
    none: State = State(name='ε')
    def __init__(self):
        self.states: set[State] = set()
        self.states.add(self.empty)
        self.state: list[State] = []
        self.push(self.empty)
    def push(self, state: State):
        assert state in self.states or state == self.none
        if state != self.none:
            self.state.append(state)
            print('PUSH', state, self.state)
    def pop(self) -> State:
        return self.state.pop()
    def is_empty(self) -> bool:
        return len(self.state) == 1 and self.state[0] == self.empty

class When:
    def __init__(self, char: str, state: State, stack: State):
        self.char: str = char
        self.state: State = state
        self.stack: State = stack
    def __repr__(self) -> str:
        return ", ".join([self.char, self.state.name, self.stack.name])

class Then:
    def __init__(self, state: State, stack: list[State]):
        self.state: State = state
        self.stack: list[State] = stack
    def __repr__(self) -> str:
        return ", ".join([self.state.name, "".join([state.name for state in self.stack])])

class Rule:
    def __init__(self, when: When, then: Then):
        self.when: When = when
        self.then: Then = then
    def __repr__(self) -> str:
        return f'Rule: {self.when} => {self.then}'

class Automata:
    def __init__(self):
        self.alphabet: set[str] = set()
        self.states: set[State] = set()
        self.accepted: set[State] = set()
        self.state: State = None
        self.stack: Stack = Stack()
        self.rules: list[Rule] = []
    def __repr__(self) -> str:
        return f'{self.__class__.__name__}: {self.state}, {self.stack.state}'
    def is_accepted(self, tape: typing.Union[str, list], by_state: bool = True, by_stack: bool = True) -> bool:
        assert self.state is not None
        assert self.state in self.states
        if tape is None or tape == '' or tape == []:
            tape = ['']
        for char in list(tape):
            if not self._is_accepted(char):
                return False
        self._is_accepted('')
        return all([
            any([not by_stack, self.stack.is_empty()]),
            any([not by_state, self.state in self.accepted]),
        ])
    def _is_accepted(self, char: str) -> bool:
        assert char in self.alphabet or char == ''
        for number, rule in enumerate(self.rules):
            if all([
                rule.when.char == char,
                rule.when.state == self.state,
                rule.when.stack == self.stack.state[-1],
            ]):
                self.state = rule.then.state
                self.stack.pop()
                for state in reversed(rule.then.stack):
                    self.stack.push(state)
                return True
        return False

q1: State = State('q1')
q2: State = State('q2')
a: State = State('a')

automata = Automata()
automata.alphabet.add('(')
automata.alphabet.add(')')
automata.state = q1
automata.states.add(q1)
automata.states.add(q2)
automata.accepted.add(q2)
automata.stack.states.add(a)

automata.rules.append(Rule(When('(', q1, a),                Then(q1, [a, a])))
automata.rules.append(Rule(When('(', q1, Stack.empty),      Then(q1, [a, Stack.empty])))
automata.rules.append(Rule(When(')', q1, a),                Then(q1, [Stack.none])))
automata.rules.append(Rule(When('', q1, Stack.empty),       Then(q2, [Stack.empty])))

assert copy.deepcopy(automata).is_accepted('', by_stack=False)
assert not copy.deepcopy(automata).is_accepted('())()))(', by_stack=False)
assert copy.deepcopy(automata).is_accepted('()(())((()))', by_stack=False)

assert copy.deepcopy(automata).is_accepted('')
assert not copy.deepcopy(automata).is_accepted('())()))(')
assert copy.deepcopy(automata).is_accepted('()(())((()))')

assert copy.deepcopy(automata).is_accepted('', by_state=False)
assert not copy.deepcopy(automata).is_accepted('())()))(', by_state=False)
assert copy.deepcopy(automata).is_accepted('()(())((()))', by_state=False)

assert copy.deepcopy(automata).is_accepted('', by_state=False)
assert not copy.deepcopy(automata).is_accepted('())()))(', by_stack=False)
assert copy.deepcopy(automata).is_accepted('()(())((()))', by_stack=False)

def grammar(state: list[str]) -> list[str]:
    assert isinstance(state, list)
    while 'S' in state:
        for position, value in enumerate(state):
            prefix: list[str] = state[:position]
            suffix: list[str] = state[position + 1:]
            if value == 'S':
                new_value: list[str] = []
                if random.choice([True, False]):
                    new_value: list[str] = ['(', 'S', ')']
                elif random.choice([True, False]):
                    new_value: list[str] = ['S', 'S']
                state: list = prefix + new_value + suffix
                break
    return state

for _ in range(20):
    string: str = ''.join(grammar(['S']))
    print('Accepted:', string)
    clone: Automata = copy.deepcopy(automata)
    assert clone.is_accepted(string)

raise Exception(2)

for _ in range(20):
    print()

q1: State = State('q1')
q2: State = State('q2')
q3: State = State('q3')
q4: State = State('q4')
q5: State = State('q5')

x: State = State('x')

automata = Automata()
automata.alphabet.add('a')
automata.alphabet.add('b')
automata.alphabet.add('c')
automata.alphabet.add('d')
automata.state = q1
automata.states.add(q1)
automata.states.add(q2)
automata.states.add(q3)
automata.states.add(q4)
automata.states.add(q5)
automata.accepted.add(q5)
automata.stack.states.add(x)

automata.rules.append(Rule(When('a', q1, x),                Then(q1, [x, x])))
automata.rules.append(Rule(When('a', q1, Stack.empty),      Then(q1, [x, Stack.empty])))
automata.rules.append(Rule(When('b', q1, x),                Then(q2, [Stack.none])))
automata.rules.append(Rule(When('b', q2, x),                Then(q2, [Stack.none])))
automata.rules.append(Rule(When('c', q2, Stack.empty),      Then(q3, [x, Stack.empty])))
automata.rules.append(Rule(When('c', q3, x),                Then(q3, [x, x])))
automata.rules.append(Rule(When('d', q3, x),                Then(q4, [Stack.none])))
automata.rules.append(Rule(When('d', q4, x),                Then(q4, [Stack.none])))
automata.rules.append(Rule(When('', q4, Stack.empty),       Then(q5, [Stack.empty])))

assert copy.deepcopy(automata).is_accepted('abcd', by_state=True, by_stack=False)
assert not copy.deepcopy(automata).is_accepted('', by_state=True, by_stack=False)

for _ in range(20):
    ab: int = random.randint(1, 100)
    cd: int = random.randint(1, 100)
    string: str = 'a' * ab + 'b' * ab + 'c' * cd + 'd' * cd
    assert copy.deepcopy(automata).is_accepted(string, by_state=True, by_stack=False)

for _ in range(20):
    a: int = random.randint(0, 100)
    b: int = a + random.randint(1, 100)
    c: int = random.randint(0, 100)
    d: int = c + random.randint(1, 100)
    string: str = 'a' * a + 'b' * b + 'c' * c + 'd' * d
    assert not copy.deepcopy(automata).is_accepted(string, by_state=True, by_stack=False)

for _ in range(30):
    print()

q1: State = State('q1')
x: State = State('x')
y: State = State('y')

automata = Automata()
automata.alphabet.add('a')
automata.alphabet.add('b')
automata.state = q1
automata.states.add(q1)
automata.accepted.add(q1)
automata.stack.states.add(x)
automata.stack.states.add(y)

automata.rules.append(Rule(When('a', q1, x),                Then(q1, [x, x])))
automata.rules.append(Rule(When('a', q1, y),                Then(q1, [Stack.none])))
automata.rules.append(Rule(When('a', q1, Stack.empty),      Then(q1, [x, Stack.empty])))
automata.rules.append(Rule(When('b', q1, x),                Then(q1, [Stack.none])))
automata.rules.append(Rule(When('b', q1, y),                Then(q1, [y, y])))
automata.rules.append(Rule(When('b', q1, Stack.empty),      Then(q1, [y, Stack.empty])))

clone: Automata = copy.deepcopy(automata); assert not clone.is_accepted('abb', by_state=False, by_stack=True)
clone: Automata = copy.deepcopy(automata); assert not clone.is_accepted('aaab', by_state=False, by_stack=True)
clone: Automata = copy.deepcopy(automata); assert clone.is_accepted('ab', by_state=False, by_stack=True)
clone: Automata = copy.deepcopy(automata); assert clone.is_accepted('abab', by_state=False, by_stack=True)
clone: Automata = copy.deepcopy(automata); assert clone.is_accepted('aabb', by_state=False, by_stack=True)
clone: Automata = copy.deepcopy(automata); assert clone.is_accepted('bbaa', by_state=False, by_stack=True)
clone: Automata = copy.deepcopy(automata); assert clone.is_accepted('aaaabbbb', by_state=False, by_stack=True)

for _ in range(20):
    total: int = random.randint(0, 100)
    string: list = list('a' * total + 'b' * total)
    random.shuffle(string)
    string: str = ''.join(string)
    clone: Automata = copy.deepcopy(automata)
    assert clone.is_accepted(string, by_state=False, by_stack=True)

for _ in range(20):
    a: int = random.randint(0, 100)
    b: int = a + random.randint(1, 100)
    string: list = list('a' * a + 'b' * b)
    random.shuffle(string)
    string: str = ''.join(string)
    clone: Automata = copy.deepcopy(automata)
    assert not clone.is_accepted(string, by_state=False, by_stack=True)
