import os

def bad_idea(user_input):
    # CodeQL should flag this as a command injection risk
    os.system("echo " + user_input)

# trigger
bad_idea("hello; rm -rf /")
