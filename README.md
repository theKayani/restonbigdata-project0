# BigData Project 0
## Scala CLI Application
### Numbers to Words
This Scala command line application will take numbers and their textual equivalents and insert them into a database. Also performing CRUD on these numbers and texts.

#### Features:
- Convert a number into its textual equivalent in a specific language
- Add bulk entries of numbers and their textual equivalents using `JSON` files
- Also can create, update, and delete specific records

#### Examples:

- The `give` command is used to retrieve numbers as text. For example, to get 20 in english, the command would look like...
  ```
  give english 20
  ```
  This would produce a result like `twenty`.
  ```
  give spanish 100
  ```
  should look like `cien`
- The `import` command is used to pull data from a `json` file and insert all the rows/records extracted into the database...

  This is what the `json` file should look like
  ```json
  {
      "[language]": {
          "[number]": "[word]"
      },
      ...
  }
  ```
  so as an example...
  ```json
  {
      "english": {
          "1": "one",
          "2": "two",
          "3": "three",
          "4": "four",
          "5": "five",
          "6": "six",
          "7": "seven",
          "8": "eight",
          "9": "nine"
      },
      "spanish": {
          "10": "diez",
          "20": "veinte",
          "30": "treinta",
          "40": "cuarenta",
          "50": "cinquenta",
          "60": "sesenta",
          "70": "setenta",
          "80": "ochenta",
          "90": "noventa"
      }
  }
  ```
- The `help` command returns a list of available commands to run. This can be very useful!
_to be continued..._