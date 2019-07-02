# News
For working As CICD
please add following change in .git folder

# Open Pre-Push.sample and paste the code in there
```
CMD="./gradlew clean testDebugUnitTest"
//Check if we actually have commits to push
commits=`git log @{u}..`
if [ -z “$commits” ]; then
 exit 0
fi
$CMD
RESULT=$?
if [ $RESULT -ne 0 ]; then
 echo “failed $CMD”
 exit 1
fi
exit 0
```

# Save file and remove ".sample" in the extention to make it executable.
