TOPIC=${1:-messaggi-classe}
docker exec -i aula_kafka kafka-topics.sh --create --topic "$TOPIC" --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1 || true
echo "Requested creation of topic: $TOPIC"