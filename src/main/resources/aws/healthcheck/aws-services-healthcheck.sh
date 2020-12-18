#!/usr/bin/env bash

check_services () {
  QUEUES_OUTPUT="$(awslocal sqs list-queues)"
  if [[ $QUEUES_OUTPUT == *"test_queue"* ]]; then
    echo "OK: $QUEUES_OUTPUT"
    return 0
  else
    echo "NOK: $QUEUES_OUTPUT"
    return 1
  fi
}
check_services