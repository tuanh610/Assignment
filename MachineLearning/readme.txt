Assumption:

1. This will ignore all attachements, only raw text message will be processed 

2. This will ignore all emails which has non ASCII character 

3. This will only use 10000 entries of the mail. This limitation is due to the Jupiter lab restriction on memory usage 
(so when processing too much data it will prompt memory error). 
If this code is ran on PyCharm with properly configure settings it should be able to process all data at once.

4. Please download and extract the malldir folder to the same folder as the .jpynb file, this submission does not include it to reduce zip file size