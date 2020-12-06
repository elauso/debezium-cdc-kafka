#!/bin/bash
curl -i -X POST -H "Content-Type: application/json" localhost:8083/connectors --data-binary "@connector-config.json"