#!/bin/bash

export PYTHONPATH=$(pwd)
python3 -m venv .venv
source .venv/bin/activate
pip install beautifulsoup4

log_dir_name="./logs"
subjects=$1

if [ ! -d "$log_dir_name" ] 
then
    $(mkdir $log_dir_name)
fi

echo ""
echo "################################################"
echo "Starting Nimrod-hunor analysis."
echo "Directory: $subjects"

for d in $subjects/* ; do
    if [ -d $d ] 
    then
        echo -n "Starting $d analysis..."         
        temp1=$(basename $d)
        temp2=$(date '+%Y%m%d%H%M%S')
        log_file_name="${temp1}-${temp2}"
        python $d/run_nimrod.py > $log_dir_name/$log_file_name.log
        echo "finished"
    fi
done

echo "Finished Nimrod-hunor analysis."
echo "Check log files at $log_dir_name directory."