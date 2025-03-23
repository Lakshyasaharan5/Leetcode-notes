class Solution:
    def isValid(self, s: str) -> bool:
        stack = []

        # Mapping of closing parentheses to their corresponding opening parentheses
        matching_brackets = {")": "(", "]": "[", "}": "{"}

        for paran in s:
            # If the character is a closing parenthesis
            if paran in matching_brackets:
                # Check if the stack is empty or the top of the stack doesn't match
                if len(stack) == 0 or stack[-1] != matching_brackets[paran]:
                    return False
                stack.pop()  # Remove the last element in the stack (this was a valid match)
            else:
                # If it's an opening parenthesis, push it onto the stack
                stack.append(paran)

        # If stack is empty, all parentheses are matched
        if len(stack) == 0:
            return True
        else:
            return False
