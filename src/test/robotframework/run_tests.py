import os
from robot import run

def run_robot_tests():
    tests_directory = 'tests'

    all_files = os.listdir(tests_directory)

    test_files = [os.path.join(tests_directory, file) for file in all_files if file.endswith('.robot')]

    for test_file in test_files:
        results = run(test_file)
        print(results)

if __name__ == "__main__":
    run_robot_tests()
