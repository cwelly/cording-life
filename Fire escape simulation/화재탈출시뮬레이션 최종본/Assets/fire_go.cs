using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class fire_go : MonoBehaviour {
    Vector3 wan_arri = new Vector3(250.93f, 53.23f, 62.43f);
    // Use this for initialization
    void Start () {
		
	}
	
	// Update is called once per frame
	void Update () {
        gameObject.transform.position = Vector3.MoveTowards(gameObject.transform.position, wan_arri, Time.deltaTime * 1.1f);
    }
}
