How to use:

1. Copy and paste your desired transition rules from the JSON files in the folder to the text area in the index.html.
2. Input your tape content. Take note that each symbol needs to be seperated with spaces e.g 1 1 0 1 B 1 0 1
3. Initiliaze the head by "initial state" symbol followed by the index of the starting head position e.g. s1 1 (This will change depending on the ruleset that you have inputted).
4. Press run.

Note for the JSON file rulesets:

Binary Addition Head Initialization: Initial state symbol is s1 followed by index of the far right digit ignoring the B symbols e.g. 1 0 1 B 1 will need to have a "s1 4" as its proper initialization.

Unary Multiplication Head Initialization: Initial state symbol is s1 followed by the number 1 e.g. "s1 1"

Binary Multiplcation Head Initilization: Initial state symbol is s0 followed by index of the far right digit ignoring the B symbols e.g. 1 0 1 B 1 will need to have a "s0 4" as its proper initialization.
