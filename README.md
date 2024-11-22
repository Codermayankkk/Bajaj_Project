# Endpoints

## POST /process_data
This endpoint accepts a JSON object and processes it to return the following information:

Status: Response status of the operation.

User ID: The user identifier.

College Email ID: The email address associated with the user's college.

College Roll Number: The student's roll number in college.

Array of Numbers: An array of numbers extracted from the input.

Array of Alphabets: An array of alphabetic characters extracted from the input.

Highest Lowercase Alphabet: The highest alphabetical character in lowercase from the input.

Prime Check: A boolean value indicating if a prime number was found in the input numbers.

File Information: Details about the uploaded file, including:

Validity: Whether the file is valid.

MIME Type: MIME type of the uploaded file.

File Size: Size of the file in KB.

## GET /operation_code

This endpoint returns an operation code to indicate the status or type of operation being executed.

## File Handling

The API supports file uploads and validates the file's format and size, 
ensuring it meets specified requirements.

This simple API demonstrates how to handle JSON inputs, 
file processing, and returns structured responses.
