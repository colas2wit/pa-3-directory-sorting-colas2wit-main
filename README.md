# Assignment 3: Directory Sorting

In this assignment, you will be sorting entries in a directory.  The fields to sort on will be:
* File name (alphanumeric)
* File size (integer bytes)
* Date-time (yyyymmddHHMMSS)

For example, the directory may include the following entries:
```
file1 8192 20221231045722
AnOtHaFiLe 10000 20190533123100
oldF1l3 2 19710710001267
```

You will implement the three methods in the `DirectorySorter` class:
* `sortByFileName()`
* `sortByFileSize()`
* `sortByDateTime()`
